/*
 * Copyright 2021 Matthias Kellnhofer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog
import java.net.URL

val dummyDogs = listOf(
    Dog(
        id = 1L,
        name = "Arrow",
        imageResId = R.drawable.dog_1,
        breed = "Shetland Sheepdog",
        age = 5,
        description = "The Shetland Sheepdog, often known as the Sheltie, is a breed of herding " +
            "dog that originated in the Shetland Islands of Scotland. The original name was " +
            "Shetland Collie, but this caused controversy among the Rough Collie breeders of" +
            " the time, so the breed's name was formally changed. This hard-working small do" +
            "g is intelligent, vocal, excitable and willing to please. They are incredibly l" +
            "oyal to their owners to the point where they are often referred to as \"shadows" +
            "\" due to their attachment to family. This breed was formally recognized by The" +
            " Kennel Club (UK) in 1909.",
        link = URL("https://en.wikipedia.org/wiki/Shetland_Sheepdog")
    ),
    Dog(
        id = 2L,
        name = "Riley",
        imageResId = R.drawable.dog_2,
        breed = "White Terrier",
        age = 1,
        description = "The West Highland White Terrier, commonly known as the Westie, is a breed" +
            " of dog from Scotland with a distinctive white harsh coat with a somewhat soft " +
            "white undercoat. It is a medium-sized terrier, although with longer legs than o" +
            "ther Scottish breeds of terrier. It has a white double coat of fur which fills " +
            "out the dog's face, giving it a rounded appearance.",
        link = URL("https://en.wikipedia.org/wiki/West_Highland_White_Terrier")
    ),
    Dog(
        id = 3L,
        name = "Spot",
        imageResId = R.drawable.dog_3,
        breed = "Bearded Collie",
        age = 7,
        description = "The Bearded Collie ranks 117 out of 175 breeds in popularity in the Unite" +
            "d States, according to the American Kennel Club's yearly breed ranking. A Beard" +
            "ed Collie is best obtained from a reputable breeder or a dog rescue. There are " +
            "Beardie rescue associations, such as Beardie Collie Rescue and \"Rescue Me\". T" +
            "hese organisations attempt to place unwanted puppies and dogs into appropriate," +
            " loving homes. Most Bearded Collie breeders take great care in breeding, raisin" +
            "g and placing their puppies. Due to this, Bearded Collies are considered an \"u" +
            "nspoiled\" breed.",
        link = URL("https://en.wikipedia.org/wiki/Bearded_Collie")
    ),
    Dog(
        id = 4L,
        name = "Apollo",
        imageResId = R.drawable.dog_4,
        breed = "Beagle",
        age = 3,
        description = "The beagle is a breed of small hound that is similar in appearance to the" +
            " much larger foxhound. The beagle is a scent hound, developed primarily for hun" +
            "ting hare (beagling). Possessing a great sense of smell and superior tracking i" +
            "nstincts, the beagle is the primary breed used as detection dogs for prohibited" +
            " agricultural imports and foodstuffs in quarantine around the world. The beagle" +
            " is intelligent. It is a popular pet due to its size, good temper, and a lack o" +
            "f inherited health problems",
        link = URL("https://en.wikipedia.org/wiki/Beagle")
    ),
    Dog(
        id = 5L,
        name = "Rusty",
        imageResId = R.drawable.dog_5,
        breed = "Irish Setter",
        age = 4,
        description = "The Irish Setter (Irish: sotar rua, literally \"red setter\") is a setter" +
            ", a breed of gundog, and family dog. The term Irish Setter is commonly used to " +
            "encompass the show-bred dog recognised by the American Kennel Club as well as t" +
            "he field-bred Red Setter recognised by the Field Dog Stud Book.",
        link = URL("https://en.wikipedia.org/wiki/Irish_Setter")
    ),
    Dog(
        id = 6L,
        name = "Max",
        imageResId = R.drawable.dog_6,
        breed = "Swiss Mountain Dog",
        age = 7,
        description = "Sennenhund, called Swiss mountain dogs or Swiss cattle dogs in English, a" +
            "re a type of dog originating in the Swiss Alps. The Sennenhund are farm dogs of" +
            " the general molosser type. There are four breeds of Sennenhund, all sporting a" +
            " unique tricolor coat. While the two larger ones share a heavy build and a calm" +
            " temperament, the two smaller ones are more agile. The breeds range from medium" +
            " in size to very large. The name Sennenhund refers to people called Senn or Sen" +
            "ner, Swiss Alpine herdsmen and dairymen, and does not translate as \"mountain\"" +
            " or \"cattle\".",
        link = URL("https://en.wikipedia.org/wiki/swiss_mountain_dog")
    ),
    Dog(
        id = 7L,
        name = "Sam",
        imageResId = R.drawable.dog_7,
        breed = "Labrador Retriever",
        age = 1,
        description = "The Labrador Retriever, often abbreviated to Labrador, is a breed of retr" +
            "iever-gun dog from the United Kingdom that was developed from imported Canadian" +
            " fishing dogs. The Labrador is one of the most popular dog breeds in a number o" +
            "f countries in the world, particularly in the Western world.",
        link = URL("https://en.wikipedia.org/wiki/Labrador_Retriever")
    ),
    Dog(
        id = 8L,
        name = "Rocky",
        imageResId = R.drawable.dog_8,
        breed = "Border Collie",
        age = 1,
        description = "The Border Collie is a working and herding dog breed developed in the Ang" +
            "lo-Scottish border region, for herding livestock, especially sheep.",
        link = URL("https://en.wikipedia.org/wiki/Border_Collie")
    ),
    Dog(
        id = 9L,
        name = "Dexter",
        imageResId = R.drawable.dog_9,
        breed = "Golden Retriever",
        age = 1,
        description = "The Golden Retriever is a medium-large gun dog that was bred to retrieve " +
            "shot waterfowl, such as ducks and upland game birds, during hunting and shootin" +
            "g parties. The name \"retriever\" refers to the breed's ability to retrieve sho" +
            "t game undamaged due to their soft mouth. Golden retrievers have an instinctive" +
            " love of water, and are easy to train to basic or advanced obedience standards." +
            " They are a long-coated breed, with a dense inner coat that provides them with " +
            "adequate warmth in the outdoors, and an outer coat that lies flat against their" +
            " bodies and repels water. Golden retrievers are well suited to residency in sub" +
            "urban or country environments.",
        link = URL("https://en.wikipedia.org/wiki/Golden_Retriever")
    ),
    Dog(
        id = 10L,
        name = "Jake",
        imageResId = R.drawable.dog_10,
        breed = "Welsh Sheepdog",
        age = 1,
        description = "The Welsh Sheepdog is a landrace of herding dog from Wales. Some people i" +
            "ncorrectly call a Welsh Sheepdog a Welsh Collie - usually 'Welsh Collie' is use" +
            "d for a cross between a Welsh Sheepdog and a Border Collie, who is often a mild" +
            "er dog and easier to manage than the pure breed.",
        link = URL("https://en.wikipedia.org/wiki/Welsh_Sheepdog")
    )
)

class DogRepo {

    private val dogs = MutableLiveData(dummyDogs)

    fun getAllDogs(): LiveData<List<Dog>> = dogs

    fun getDogById(id: Long): LiveData<Dog?> = dogs.map { dogs -> dogs.find { it.id == id } }
}
