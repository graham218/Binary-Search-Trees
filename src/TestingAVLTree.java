import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class TestingAVLTree {


    /**
     *
     * @param args arg[0] is the name of the input file, arg[1] is the name of the ouput file which will be in order,
     *             args[2] is the name of the output file that will be displayed level by level from left to right
     */
    public static void main( String [] args) {

        //Argument checking
        if(args.length != 3){
            System.err.println("Not enough arguments");
            System.exit(1);
        }

        //Create Binary Tree
        AVLTree mainTree = new AVLTree();

        //Get input
        try{
            String word;
            String filePath = ("input/" + args[0]);
            BufferedReader buff = new BufferedReader(new FileReader(filePath));

            while( (word = buff.readLine()) != null ){
                char [] temp = word.toCharArray();

                if( temp[0] == 'I'){
                    char[] data = Arrays.copyOfRange(temp,1,temp.length);
                    mainTree.insert(data);
                }
                else{
                    System.err.println("Data field does not contain I or D as a first character.");
                    System.exit(0);
                }

            }




        } catch (IOException e){
            System.err.println("An IOException has been caught: " + e.getMessage());
        }
        /*catch (Exception e){
            System.err.println("An Exception has been caught line 56: " + e.getMessage());
        }*/

        System.out.println("Finished Inserting");


        //Output to file stored in args[1] in order

        try {
            FileWriter writer = new FileWriter(args[1]);
            writer.write("StudentNumber     LastName                  HomeDepartment   Program   Year\n\n");
            mainTree.inorder(mainTree.root, writer);
            writer.close();
        }
        catch (IOException e){
            System.err.println("An IOException has been caught: " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("An exception has been caught: " + e.getMessage());
        }


        //Output to file stored in args[2] level by level
        try {
            FileWriter writer2 = new FileWriter(args[2]);
            writer2.write("StudentNumber     LastName                  HomeDepartment   Program   Year\n\n");
            mainTree.breadthFirst(writer2);
            writer2.close();
        }
        catch (IOException e){
            System.err.println("An IOException has been caught: " + e.getMessage());
        }
        catch (Exception e){
            System.err.println("An exception has been caught: " + e.getMessage());
        }

        System.out.println("Done");
    }
}
