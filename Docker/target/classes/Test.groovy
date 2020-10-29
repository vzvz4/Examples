class Human {
    String name, color
    def age, height

    def resolve(person) {
        println "$person.age $person.height"
        person.age
    }
}

def printHuman(person) {
    println person
    def h = new Human(age: 2, height: 100)
    person.resolve(h)
}

def hh = new Human(name: 'Harold', color: 'Black')
println printHuman(hh)
