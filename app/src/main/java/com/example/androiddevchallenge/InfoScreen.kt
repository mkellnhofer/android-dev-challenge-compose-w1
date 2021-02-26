package com.example.androiddevchallenge

import androidx.annotation.PluralsRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.DogRepo
import com.example.androiddevchallenge.data.dummyDogs
import com.example.androiddevchallenge.model.Dog

@Composable
fun InfoScreen(
    navController: NavController,
    repository: DogRepo,
    dogId: Long?
) {
    val dog = dogId?.let { repository.getDogById(it).observeAsState().value } ?: return

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .clickable { navController.popBackStack() },
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null
                    )
                },
                title = {
                    Text(text = dog?.name)
                }
            )
        }
    ) {
        DogInfo(
            modifier = Modifier.fillMaxWidth(),
            dog = dog
        )
    }
}

@Composable
fun DogInfo(
    modifier: Modifier,
    dog: Dog,
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Surface(
                modifier = Modifier
                    .size(200.dp),
                shape = CircleShape,
            ) {
                Image(
                    painter = painterResource(dog.imageResId),
                    contentDescription = null,
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(
                modifier = Modifier.width(70.dp),
                text = stringResource(id = R.string.label_breed) + ":",
                fontWeight = FontWeight.SemiBold
            )
            Text(text = dog.breed)
        }
        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(
                modifier = Modifier.width(70.dp),
                text = stringResource(id = R.string.label_age) + ":",
                fontWeight = FontWeight.SemiBold
            )
            Text(text = dog.age.toString() + " " + quantityStringResource(R.plurals.plurals_years,
                dog.age))
        }
        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(
                modifier = Modifier.width(70.dp),
                text = stringResource(id = R.string.label_info) + ":",
                fontWeight = FontWeight.SemiBold
            )
            Text(text = dog.description)
        }
        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(
                modifier = Modifier.width(70.dp),
                text = stringResource(id = R.string.label_wiki) + ":",
                fontWeight = FontWeight.SemiBold
            )
            Text(text = dog.link.toString())
        }
    }
}

@Preview
@Composable
fun DogInfoPreview() {
    DogInfo(Modifier, dummyDogs[0])
}

@Composable
fun quantityStringResource(@PluralsRes id: Int, quantity: Int): String {
    return LocalContext.current.resources.getQuantityString(id, quantity)
}
