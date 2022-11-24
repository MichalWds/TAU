# Mockowanie & Stub

Stubbing vs mocking
- Główną różnicą między stubbingiem a mockowaniem jest fakt, że stubbing doprowadza prostą implementację 
zachowania np metody. Możemy to nazwać imitacją właściwej implementacji. 
- Przy mockowaniu ustalamy "odgórnie" co będzie zwrócone. Określamy jakich interakcji się spodziewamy, po czym
możemy zweryfikować czy one faktycznie wystąpiły.

1. Przykłady mockowania można podejrzeć w zasadzie w każdej klasie testującej serwis, np: 
- AuthorServiceTest
- MovieServiceTest
- RatingServiceTest

mockowane są serwisy oraz repozytoria.

2. Przykład mniej popularnego stubbingu pod ścieżką : 

`4/movieApp-main/src/test/java/movieApp/stub/StubTest.java`
