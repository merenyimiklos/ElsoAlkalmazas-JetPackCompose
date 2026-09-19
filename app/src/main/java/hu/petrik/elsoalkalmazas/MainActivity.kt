package hu.petrik.elsoalkalmazas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.petrik.elsoalkalmazas.ui.theme.ElsoAlkalmazasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElsoAlkalmazasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KotlinAlapok(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun KotlinAlapok(modifier: Modifier = Modifier) {
    Text(
        //text = matematikaiDemo().joinToString("\n"),
        text = rangeDemo().joinToString("\n"),
        modifier = Modifier.padding(25.dp)
    )
}

fun valotozokDemo(): List<String> {
    val nev = "Pista"   //nem változtatható
    var kor = 10        //változtatható


    var magassag: Double = 1.85
    var tanulo: Boolean = true
    var osztaly: Char = 'A'

    return listOf(
        "Név: $nev",
        "Kor: $kor",
        "Magassag: $magassag",
        "Tanulo: $tanulo",
        "Osztaly: $osztaly"
    )
}

fun matematikaiDemo(): List<String> {

    val szam1 = 10.0
    val szam2 = 3

    return listOf(
        "$szam1 + $szam2 = ${szam1 + szam2}",
        "$szam1 - $szam2 = ${szam1 - szam2}",
        "$szam1 * $szam2 = ${szam1 * szam2}",
        "$szam1 / $szam2 = ${szam1 / szam2}",
        "$szam1 % $szam2 = ${szam1 % szam2}"
    )
}

fun elagazasokDemo(kor: Int): String {

    return if (kor < 18)
        "Nem nagykorban vagyunk"
    else if (kor < 25) "Nagykorban vagyunk"
    else "Már teljesen nagykorúak vagyunk"
}

fun jegyDemo(jegy: Int): String {
    return when (jegy) {
        5 -> "Jeles"
        4 -> "Jó"
        3 -> "Közepes"
        2 -> "Elégséges"
        1, 0 -> "Elégtelen"
        else -> "Érvénytelen jegy"
    }
}

fun rangeDemo(): List<String> {

    val eredmeny = mutableListOf<String>()

    //.. -> <= és >=
    //until -> <= és >
    //downTo
    //step léptetés
    for (i in 0..10 step 2){
        eredmeny.add("Szam: $i")
    }
    return eredmeny
}



