<h2 title="title">Rounded star shape and polygon shape  for Jetpack Compose
</h2>

<p align="center">
  <img height="100" src="readme_assets/star.jpg">
  <img height="100" src="readme_assets/poly.jpg">
</p>
 
<br>
<br>

## How to install

copy `compose-polygonshape` directory to your project directory.
<br>

Add entry  `compose-polygonshape` to the existing app entry `settings.gradle`

```groovy
include ':app', ':compose-polygonshape'
```

Add as dependency in `app/build.gradle`
```groovy
dependencies {

    ...
    implementation project(path: ':compose-polygonshape')

}
```

#### In case of build errors, simply copy  <a href="compose-polygonshape/src/main/java/com/pz64/shape"><strong>these classes</strong></a> to your project.

## Usage

### RoundedStarShape()

``` kotlin
val roundedStarShape = RoundedStarShape(
    sides = 5,
    curve = 0.09,
    rotation = 0f,
    iterations = 360
)

Surface(
    shape = roundedStarShape,
) {
    Box(
        modifier = Modifier
            .background(color = Color(0x70205C47))
            .size(160.dp),
        contentAlignment = Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = "",
            modifier = Modifier.size(56.dp)
        )
    }
}
```
#### Output
<img height="100" src="readme_assets/star_curve0.09.jpg">

<br>

### All adjustments
<img height="500" alt="GIF" src="readme_assets/rounded_star.gif" />

<br>
### PolygonShape()

``` kotlin
val polygonShape = PolygonShape(sides = 5, rotation = 0f)

Surface(
    shape = polygonShape,

) {
    Box(
        modifier = Modifier
            .background(color = Color(0x70205C47))
            .size(160.dp),
        contentAlignment = Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_icon_2),
            contentDescription = "",
            modifier = Modifier.size(56.dp)
        )
    }
}
```
#### Output
<img height="100" src="readme_assets/poly_pentagon.jpg">

<br>

### All adjustments
<img height="500" alt="GIF" src="readme_assets/polygon.gif" />

<br>
<br>

## License

Distributed under the MIT License. See `LICENSE` for more information.