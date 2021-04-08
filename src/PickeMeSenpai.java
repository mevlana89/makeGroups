public class PickeMeSenpai {

    public static void main (String[] args) {
        String[] eleves = new String[]{ "Jérôme", "Nicolas", "Sandrine", "Stéphane", "Maxime", "Hajar", "Christophe", "Mustafa", "Huber" };
        displayGroups(makeGroups(eleves, 4));

    }

    public static void displayGroups(String[][] groupsList){
        for(int i=0; i< groupsList.length; i++){
            String groupe = "Groupe "+(i+1)+" : ";
//            System.out.print("Groupe "+ (i+1) + " : ");
            for(int j=0; j < groupsList[i].length; j++){
                if (groupsList[i][j] != null) {
                    groupe += groupsList[i][j];
                    if (j + 1 < groupsList[i].length && groupsList[i][j+1] != null) {
                        groupe += ", ";
                    }
                }
            }
            System.out.println(groupe);
        }
    }

    public static String[][] makeGroups(String[] studentList, int nbMinPerGroup ){
        int nbgGroup = studentList.length / nbMinPerGroup;
//        boolean plus1 = (studentList.length % nbMinPerGroup > 0);
        int maxPersonPerGroup = (studentList.length % nbgGroup > 0)?studentList.length/nbgGroup+1:studentList.length/nbgGroup;
        int cptGrp = 0;
        int cptIngroup = 0;
        int optPersonPerGroup=studentList.length/nbgGroup;
        System.out.println(nbgGroup);
        System.out.println(maxPersonPerGroup);
        String[][] groupsList = new String[nbgGroup][maxPersonPerGroup];
        for (String stud : studentList)  {
           // for (int i=1; i<=)
            int rand;
            do {
                rand = (int)Math.floor(Math.random() * studentList.length);
                groupsList[cptGrp][cptIngroup] = studentList[rand];
            } while(studentList[rand] == null);
            studentList[rand]=null;
            if (nbgGroup-1 != cptGrp && cptIngroup == optPersonPerGroup -1 )
            {
                cptGrp++;
                cptIngroup=0;
            }
            else
            {
                cptIngroup++;
            }
        }
        return groupsList;
    }
}
