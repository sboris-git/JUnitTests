package tests;

        import org.junit.runner.JUnitCore;
        import org.junit.runner.Result;
        import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        //Load all type of results in the result object
        Result result = JUnitCore.runClasses(TestsNegative.class);
        //Getting the run count from the result object
        System.out.println("Total number of tests " + result.getRunCount());
        //Get the failure count from the result object
        System.out.println("Total number of tests failed " + result.getFailureCount());
        //Measure testing duration
        System.out.println("The tests has fired for "+result.getRunTime()+" secs");

        for(Failure failure : result.getFailures())
        {
            //Print message only in case of failure
            System.out.println(failure.getMessage());
        }
        //Print the overall test result in boolean type
        System.out.println(result.wasSuccessful());

    }

}