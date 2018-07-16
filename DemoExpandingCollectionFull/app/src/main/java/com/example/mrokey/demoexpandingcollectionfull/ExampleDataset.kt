package com.example.mrokey.demoexpandingcollectionfull

import java.util.Arrays.asList
import com.ramotion.expandingcollection.ECCardData
import java.util.*


class ExampleDataset {

    private val dataset: MutableList<ECCardData<*>>

    init {
        dataset = ArrayList(5)

        val item5 = CardData()
        item5.mainBackgroundResource = R.drawable.attractions
        item5.headBackgroundResource = R.drawable.attractions_head
        item5.headTitle = "Attractions"
        item5.personMessage = "Usus de bassus buxum, desiderium index!"
        item5.personName = "Marjorie Ellis"
        item5.personPictureResource = R.drawable.marjorie_ellis
        item5.setListItems(prepareCommentsArray())
        dataset.add(item5)

        val item4 = CardData()
        item4.mainBackgroundResource = R.drawable.city_scape
        item4.headBackgroundResource = R.drawable.city_scape_head
        item4.headTitle = "City Scape"
        item4.personMessage = "Solems manducare, tanquam neuter verpa."
        item4.personName = "Mattew Jordan"
        item4.personPictureResource = R.drawable.mattew_jordan
        item4.setListItems(prepareCommentsArray())
        dataset.add(item4)

        val item3 = CardData()
        item3.mainBackgroundResource = R.drawable.cuisine
        item3.headBackgroundResource = R.drawable.cuisine_head
        item3.headTitle = "Cuisine"
        item3.personMessage = "Magnum lacteas ducunt ad orexis."
        item3.personName = "Ross Rodriguez"
        item3.personPictureResource = R.drawable.ross_rodriguez
        item3.setListItems(prepareCommentsArray())
        dataset.add(item3)

        val item2 = CardData()
        item2.mainBackgroundResource = R.drawable.nature
        item2.headBackgroundResource = R.drawable.nature_head
        item2.headTitle = "Nature"
        item2.personName = "Tina Caldwell"
        item2.personMessage = "Nunquam perdere clabulare."
        item2.setListItems(prepareCommentsArray())
        item2.personPictureResource = R.drawable.tina_caldwell
        dataset.add(item2)

        val item1 = CardData()
        item1.mainBackgroundResource = R.drawable.night_life
        item1.headBackgroundResource = R.drawable.night_life_head
        item1.headTitle = "Night Life"
        item1.personMessage = "Cur adelphis studere?"
        item1.personName = "Wallace Sutton"
        item1.personPictureResource = R.drawable.wallace_sutton
        item1.setListItems(prepareCommentsArray())
        dataset.add(item1)

    }

    fun getDataset(): List<ECCardData<*>> {
        dataset.shuffle()
        return dataset
    }

    private fun prepareCommentsArray(): MutableList<Comment> {
        val random = Random()
        val comments : MutableList<Comment> = ArrayList()
        comments.addAll(Arrays.asList(
                Comment(R.drawable.aaron_bradley, "Aaron Bradley", "When the sensor experiments for deep space, all mermaids accelerate mysterious, vital moons.", "jan 12, 2014"),
                Comment(R.drawable.barry_allen, "Barry Allen", "It is a cold powerdrain, sir.", "jun 1, 2015"),
                Comment(R.drawable.bella_holmes, "Bella Holmes", "Particle of a calm shield, control the alignment!", "sep 21, 1937"),
                Comment(R.drawable.caroline_shaw, "Caroline Shaw", "The human kahless quickly promises the phenomenan.", "may 23, 1967"),
                Comment(R.drawable.connor_graham, "Connor Graham", "Ionic cannon at the infinity room was the sensor of voyage, imitated to a dead pathway.", "sep 1, 1972"),
                Comment(R.drawable.connor_graham, "Deann Hunt", "Vital particles, to the port.", "aug 13, 1995"),
                Comment(R.drawable.ella_cole, "Ella Cole", "Stars fly with hypnosis at the boldly infinity room!", "nov 18, 1952"),
                Comment(R.drawable.jayden_shaw, "Jayden Shaw", "Hypnosis, definition, and powerdrain.", "apr 1, 2013"),
                Comment(R.drawable.jerry_carrol, "Jerry Carrol", "When the queen experiments for nowhere, all particles control reliable, cold captains.", "nov 14, 1964"),
                Comment(R.drawable.lena_lucas, "Lena Lukas", "When the c-beam experiments for astral city, all cosmonauts acquire remarkable, virtual lieutenant commanders.", "may 4, 1965"),
                Comment(R.drawable.leonrd_kim, "Leonard Kim", "Starships walk with love at the cold parallel universe!", "jul 3, 1974"),
                Comment(R.drawable.marc_baker, "Mark Baker", "Friendship at the bridge that is when quirky green people yell.", "dec 24, 1989")))
        Collections.shuffle(comments)
        return comments.subList(0, 6 + random.nextInt(5))
    }
}   