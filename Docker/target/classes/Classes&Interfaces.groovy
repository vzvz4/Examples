// Объявление интерфейса
interface Voice{
    void voice();
    String getAnimalName();
}
// его реализация
class Dog implements Voice{

    @Override
    void voice() {
        println "Gav"
    }

    @Override
    String getAnimalName() {
        return Dog.class.getSimpleName()
    }

    void goMethod(){

    }
}
// и использование
def dog = new Dog() as Voice
println dog.class

Voice v = new Dog()
println v.class

dog.voice()
v.voice()

// или можно привести к интерфейсу таким способом:
def dog2 = new Dog().asType(Voice.class)

dog.voice()
println "my name is: " + dog.getAnimalName()

// Реализация интерфейса как замыкания
def mainRunnable = {
    run:{
        try {
            int i = 5
            while (i>0) {
                sleep(1000)
                println "${i--}"
            }
        } catch (InterruptedException ex) {
            // error
        }
    }
} as Runnable

new Thread(mainRunnable).start()