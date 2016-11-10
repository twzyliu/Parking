import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
class Report {

    private String space;
    private String report;

    public Report(String space) {
        this.space = space;
        this.report = "";
    }

    public String  printParkinglot(int getSpace , int capacity ) {
        report += space + "Parkinglot:" + getSpace + "/" + capacity + "\n";
        System.out.print(report);
        return report;
    }


    public String printParker(List<withParkingCapability> parkings) {
        report += space + "Parker\n";
        space += "  ";
        for (withParkingCapability w : parkings) {
            report += w.play(space);
        }
        System.out.print(report);
        return report;
    }

}
