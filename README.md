# A sample Spring Boot app

Here are a few random notes...

## Milestone 1

* Changed default Mustache templates extension to `.html` via `application.properties`.

## Milestone 2

* At some time, I managed to run `PastryServiceTest.java`, without having to create an actual implementation of `IPastryRepository`. Then I got this error, which forced me to implement `PastryRepository`:

    Parameter 0 of constructor in me.benoithubert.mngecom.PastryService required a bean of type 'me.benoithubert.mngecom.IPastryRepository' that could not be found.
