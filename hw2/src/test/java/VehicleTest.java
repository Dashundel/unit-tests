import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
* Написать следующие тесты c использованием Junit5:
- проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
- проверка того, объект Car создается с 4-мя колесами
- проверка того, объект Motorcycle создается с 2-мя колесами
- проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
- проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
- проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
машина останавливается (speed = 0)
- проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта)
мотоцикл останавливается (speed = 0)
* */
public class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;
    @BeforeEach
    void setup() {
        car = new Car("Kia", "Rio", 2010);
        //(String company, String model, int year
        motorcycle = new Motorcycle("Hyundai", "GSX-R", 2000);
    }
    @Test
    public void testCarIsInstanceOfVehicle() {
        //Car car = new Car("Kia", "Rio", 2010);
        assertTrue(car instanceof Vehicle);
    }
    @Test
    public void testCarHaveFourWheels() {
        //Car car = new Car("Kia", "Rio", 2010);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
    @Test
    public void testMotorcycleHaveTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }
    @Test
    public void testCarSpeedTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }
    @Test
    public void testMotorcycleSpeedTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }
    @Test
    public void testCarSpeedPark() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }
    @Test
    public void testMotorcycleSpeedPark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
