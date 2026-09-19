# Első Jetpack Compose alkalmazás – Kotlin alapok

Ez a projekt egy **első Android / Jetpack Compose órához** készült bemutató.
A cél nem az Android architektúra vagy az objektumorientált programozás megtanítása,
hanem az, hogy a diákok egy valódi Android alkalmazásban találkozzanak a legfontosabb Kotlin alapokkal.

## Mit érdemes az első órán bemutatni?

Javasolt sorrend:

1. **Jetpack Compose röviden**
   - `MainActivity`
   - `setContent`
   - `@Composable`
   - `Text`
   - `Modifier`

2. **Változók és adattípusok**
   - `val`
   - `var`
   - `String`
   - `Int`
   - `Double`
   - `Boolean`
   - `Char`

3. **Matematikai műveletek**
   - `+`
   - `-`
   - `*`
   - `/`
   - `%`
   - egész és lebegőpontos osztás különbsége

4. **Elágazások**
   - `if`
   - `else if`
   - `else`

5. **when**
   - több lehetséges érték egyszerű vizsgálata

6. **Ciklusok és range-ek**
   - `for`
   - `..`
   - `until`
   - `downTo`
   - `step`
   - `while`

7. **Függvények**
   - paraméter
   - visszatérési érték
   - egyszerű egysoros függvény

8. **Stringek és listák**
   - string template
   - `listOf`
   - `mutableListOf`
   - lista bejárása `for` ciklussal

9. **Logikai operátorok**
   - `&&`
   - `||`
   - `!`

10. **Opcionális kitekintés: null**
    - nullable típus: `String?`
    - safe call: `?.`
    - Elvis operátor: `?:`

## A példák közötti váltás

A `KotlinAlapok()` függvényben található `output` változónál lehet kiválasztani,
hogy éppen melyik példa jelenjen meg a képernyőn.

Például:

```kotlin
val output = valtozokDemo()
// val output = matematikaiDemo()
// val output = rangeDemo()
```

Az aktuális sort hagyd aktívan, a többit kommentezd ki.

## Fontos

A projektben természetesen szerepel `MainActivity` osztály, mert az Android alkalmazásnak szüksége van rá,
de az első órán ezt még nem kell objektumorientált szempontból tanítani.

A tanulóknak szánt Kotlin példák egyszerű, különálló függvényekben találhatók a
`MainActivity.kt` fájlban.
