package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.DogRepo
import com.example.androiddevchallenge.data.dummyDogs
import com.example.androiddevchallenge.model.Dog

@Composable
fun ListScreen(
    navController: NavController,
    repository: DogRepo
) {
    val dogs by repository.getAllDogs().observeAsState(emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) {
        DogList(
            modifier = Modifier.fillMaxWidth(),
            dogs = dogs,
            onClick = { navController.navigate("info/${it.id}") },
        )
    }
}

@Composable
fun DogList(
    modifier: Modifier,
    dogs: List<Dog>,
    onClick: (Dog) -> Unit,
) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
    ) {
        items(dogs) {
            DogItem(
                modifier = Modifier
                    .fillMaxWidth(),
                dog = it,
                onClick = { onClick(it) },
            )
            Divider(startIndent = 98.dp)
        }
    }
}

@Preview
@Composable
fun DogListPreview() {
    DogList(Modifier, dummyDogs) {}
}

@Composable
fun DogItem(
    modifier: Modifier,
    dog: Dog,
    onClick: () -> Unit,
) {
    Row (
        modifier = modifier
            .background(color = MaterialTheme.colors.background)
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(50.dp),
            shape = CircleShape,
        ) {
            Image(
                painter = painterResource(dog.imageResId),
                contentDescription = null,
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 24.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = dog.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.medium
            ) {
                Text(
                    text = dog.breed,
                    style = MaterialTheme.typography.body2,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun DogItemPreview() {
    DogItem(Modifier, dummyDogs[0]) {}
}