public class MobilePhone {
    //Creating properties of the class
    private String brand;
    private String name;
    private int ram;
    private int rom;
    //Setter and Getters
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getRom() {
        return rom;
    }
    public void setRom(int rom) {
        this.rom = rom;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\"MobilePhone [MobileBrand "+ brand + ", MobileName = " + name + ", RAM = " + ram + ", ROM = " + rom + "]";
    }
}