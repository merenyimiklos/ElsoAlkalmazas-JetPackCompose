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

/*
 * Ez az Android alkalmazás belépési pontja.
 *
 * Első órán ezt a részt még nem kell részletesen érteni:
 * - a MainActivity indítja el az alkalmazást;
 * - a setContent blokkban adjuk meg, mi jelenjen meg a képernyőn;
 * - Jetpack Compose-ban XML helyett Kotlin kóddal írjuk le a felületet.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // A tartalom a teljes képernyőt használhatja, akár a rendszer sávjai mögött is.
        enableEdgeToEdge()

        // A setContent blokk tartalmazza a Compose felhasználói felületet.
        setContent {
            // Az alkalmazás saját Material témája.
            ElsoAlkalmazasTheme {
                // A Scaffold egy alap képernyőelrendezést biztosít.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // A KotlinAlapok composable jeleníti meg az órai példákat.
                    KotlinAlapok(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*
 * A @Composable annotáció azt jelzi, hogy ez a függvény
 * felhasználói felületet ír le.
 *
 * A Modifier segítségével a megjelenő elemek méretét, térközét,
 * pozícióját és sok más tulajdonságát tudjuk beállítani.
 */
@Composable
fun KotlinAlapok(modifier: Modifier = Modifier) {

    /*
     * Itt lehet kiválasztani, hogy az órán melyik példát szeretnénk megjeleníteni.
     * Egyszerre elég egy sort aktívan hagyni, a többit // jellel kikommentezni.
     */
    val output = valtozokDemo()
    // val output = matematikaiDemo()
    // val output = listOf(elagazasokDemo(19))
    // val output = listOf(jegyDemo(5))
    // val output = rangeDemo()
    // val output = stringDemo()
    // val output = logikaiDemo(age = 19, hasTicket = true)
    // val output = fuggvenyDemo()
    // val output = listaDemo()
    // val output = whileDemo()
    // val output = nullDemo(nickname = null)

    Text(
        // A lista elemeit sortöréssel egyetlen szöveggé alakítjuk.
        text = output.joinToString("\n"),
        // A kívülről kapott módosítóhoz még 25 dp belső margót adunk.
        modifier = modifier.padding(25.dp)
    )
}

/*
 * VÁLTOZÓK ÉS ALAPVETŐ ADATTÍPUSOK
 *
 * val = az érték később nem cserélhető le.
 * var = az érték később módosítható.
 */
fun valtozokDemo(): List<String> {
    // A Kotlin általában magától felismeri a változó típusát.
    val name = "Pista"       // String - szöveg
    var age = 10             // Int - egész szám

    // A típust külön is megadhatjuk a változó neve után.
    val height: Double = 1.85
    val isStudent: Boolean = true
    val classLetter: Char = 'A'

    // A var értéke módosítható.
    age = age + 1

    // A += rövidített értékadás. Ugyanaz, mintha age = age + 1 lenne.
    age += 1

    return listOf(
        "Név: $name",
        "Kor: $age",
        "Magasság: $height m",
        "Tanuló: $isStudent",
        "Osztály: $classLetter"
    )
}

/*
 * MATEMATIKAI MŰVELETEK
 *
 * + összeadás
 * - kivonás
 * * szorzás
 * / osztás
 * % maradékos osztás
 */
fun matematikaiDemo(): List<String> {
    val number1 = 10.0
    val number2 = 3

    return listOf(
        "$number1 + $number2 = ${number1 + number2}",
        "$number1 - $number2 = ${number1 - number2}",
        "$number1 * $number2 = ${number1 * number2}",
        "$number1 / $number2 = ${number1 / number2}",
        "$number1 % $number2 = ${number1 % number2}",
        "7 / 2 egész számokkal = ${7 / 2}",
        "7.0 / 2 = ${7.0 / 2}"
    )
}

/*
 * ELÁGAZÁS - IF / ELSE IF / ELSE
 *
 * A feltétel eredménye mindig Boolean, vagyis true vagy false.
 * Kotlinban az if nemcsak vezérlési szerkezet, hanem értéket is visszaadhat.
 */
fun elagazasokDemo(age: Int): String {
    return if (age < 18) {
        "Még nem vagy nagykorú."
    } else if (age < 25) {
        "Nagykorú, fiatal felnőtt vagy."
    } else {
        "25 éves vagy idősebb vagy."
    }
}

/*
 * WHEN
 *
 * A when több lehetséges érték vizsgálatára használható.
 * Hasonló más nyelvek switch szerkezetéhez, de annál rugalmasabb.
 */
fun jegyDemo(grade: Int): String {
    return when (grade) {
        5 -> "Jeles"
        4 -> "Jó"
        3 -> "Közepes"
        2 -> "Elégséges"
        1, 0 -> "Elégtelen"
        else -> "Érvénytelen jegy"
    }
}

/*
 * RANGE ÉS FOR CIKLUS
 *
 * 0..10       -> 0-tól 10-ig, a 10 is benne van
 * 0 until 10  -> 0-tól 9-ig, a 10 már nincs benne
 * 5 downTo 1  -> visszafelé halad
 * step 2      -> kettesével lépked
 */
fun rangeDemo(): List<String> {
    // Ebbe a módosítható listába gyűjtjük a kiírandó szövegeket.
    val result = mutableListOf<String>()

    result.add("0..10 step 2:")
    for (i in 0..10 step 2) {
        result.add("Szám: $i")
    }

    result.add("")
    result.add("0 until 5:")
    for (i in 0 until 5) {
        result.add("Szám: $i")
    }

    result.add("")
    result.add("5 downTo 1:")
    for (i in 5 downTo 1) {
        result.add("Szám: $i")
    }

    return result
}

/*
 * STRING - SZÖVEGEK KEZELÉSE
 *
 * A $változó és a ${kifejezés} segítségével adatokat tudunk
 * közvetlenül egy szövegbe beilleszteni.
 */
fun stringDemo(): List<String> {
    val firstName = "Pista"
    val lastName = "Kiss"

    // String template: változókat illesztünk a szövegbe.
    val fullName = "$lastName $firstName"

    return listOf(
        "Teljes név: $fullName",
        "Hossz: ${fullName.length} karakter",
        "Nagybetűvel: ${fullName.uppercase()}",
        "Kisbetűvel: ${fullName.lowercase()}",
        "Tartalmazza a Pista szót: ${fullName.contains("Pista")}"
    )
}

/*
 * LOGIKAI OPERÁTOROK
 *
 * && = ÉS
 * || = VAGY
 * !  = NEM / negálás
 */
fun logikaiDemo(age: Int, hasTicket: Boolean): List<String> {
    val isAdult = age >= 18

    // Akkor igaz, ha mindkét feltétel igaz.
    val canEnter = isAdult && hasTicket

    // Akkor igaz, ha legalább az egyik feltétel igaz.
    val needsAttention = !isAdult || !hasTicket

    return listOf(
        "Nagykorú: $isAdult",
        "Van jegye: $hasTicket",
        "Beléphet: $canEnter",
        "Figyelmet igényel: $needsAttention"
    )
}

/*
 * FÜGGVÉNYEK
 *
 * A függvény:
 * - kaphat paramétereket;
 * - visszaadhat egy eredményt;
 * - ugyanazt a kódot többször is felhasználhatóvá teszi.
 */
fun fuggvenyDemo(): List<String> {
    return listOf(
        greet("Anna"),
        "5 + 7 = ${add(5, 7)}",
        "6 duplája = ${doubleNumber(6)}"
    )
}

// Egy String paramétert kap, és String értéket ad vissza.
fun greet(name: String): String {
    return "Szia, $name!"
}

// Két Int paramétert kap, és azok összegét adja vissza.
fun add(number1: Int, number2: Int): Int {
    return number1 + number2
}

// Rövidített, egysoros függvény. A Kotlin kikövetkezteti a visszatérési típust.
fun doubleNumber(number: Int) = number * 2

/*
 * LISTÁK
 *
 * listOf(...)        -> nem módosítható lista
 * mutableListOf(...) -> módosítható lista
 */
fun listaDemo(): List<String> {
    val result = mutableListOf<String>()

    // Ennek a listának az elemeit nem tudjuk hozzáadással/törléssel módosítani.
    val fruits = listOf("alma", "körte", "banán")

    // Ehhez a listához később is adhatunk új elemeket.
    val numbers = mutableListOf(10, 20, 30)
    numbers.add(40)

    result.add("Első gyümölcs: ${fruits[0]}")
    result.add("Gyümölcsök száma: ${fruits.size}")
    result.add("")

    // For ciklussal közvetlenül is végigmehetünk egy lista elemein.
    for (fruit in fruits) {
        result.add("Gyümölcs: $fruit")
    }

    result.add("")
    result.add("Számok: ${numbers.joinToString(", ")}")

    return result
}

/*
 * WHILE CIKLUS
 *
 * Addig ismétli a blokkot, amíg a feltétel igaz.
 * Fontos, hogy a feltétel egyszer hamissá váljon, különben végtelen ciklust kapunk.
 */
fun whileDemo(): List<String> {
    val result = mutableListOf<String>()
    var counter = 1

    while (counter <= 5) {
        result.add("Számláló: $counter")
        counter++
    }

    return result
}

/*
 * NULL KEZELÉS - opcionális első órás kitekintés
 *
 * A ? azt jelzi, hogy a változó értéke null is lehet.
 * Android fejlesztésnél ezzel nagyon gyakran találkozunk.
 */
fun nullDemo(nickname: String?): List<String> {
    // Az ?: az Elvis operátor. Ha nickname null, a jobb oldali értéket használja.
    val displayedName = nickname ?: "Nincs megadva becenév"

    // A ?. csak akkor hívja meg a length-et, ha az érték nem null.
    val nicknameLength = nickname?.length

    return listOf(
        "Becenév: $displayedName",
        "Becenév hossza: ${nicknameLength ?: 0}"
    )
}
