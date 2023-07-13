public class Notebooks {
    public String mainName;
    public String mainColor;
    public Integer mainRAM;
    public Integer mainHDD;

    public Boolean mainCD;



    public Notebooks(String name, String color, int RAM, int HDDsize, boolean cd) {
        mainName = name;
        mainColor = color;
        mainRAM = RAM;
        mainHDD = HDDsize;
        mainCD = cd;

    }

    @Override
    public String toString() {
        return (mainName + " " + mainColor + " " + mainRAM + " " + mainHDD +" " + mainCD);
    }

    //    public String name(Notebooks){
//        return
//    }
}
