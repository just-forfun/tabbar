Esta é a tela esta quebrando

<img src="img1.png" height="300"/>

Ao clicar no Botão, faço replace do fragment

```kotlin
fun pushFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.mainFrlContainer, fragment)
        addToBackStack("HOME")
        commit()
    }
}
```

Colocando um fragment qualquer na tela

<img src="img2.png" height="300"/>



Quando volto para tela anterior, o viewPager fica em branco e bugado

<img src="img3.png" height="300"/>

[Activity](app/src/main/java/com/example/myapplication/MainActivity.kt)

[RootFragment](app/src/main/java/com/example/myapplication/user/UserFragment.kt)
