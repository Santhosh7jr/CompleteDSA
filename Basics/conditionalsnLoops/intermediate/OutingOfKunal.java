public class OutingOfKunal {
    public static void main(String[] args) {
        
        int daysInAugust=31;

        int totalPermittedDays=0;

        for(int i=1;i<=daysInAugust;i++){
            if(i%2==0){
                totalPermittedDays+=1;
            }
        }
        System.out.println("");
        System.out.println(totalPermittedDays+" days are permitted for kunal's outing");
    }
}
