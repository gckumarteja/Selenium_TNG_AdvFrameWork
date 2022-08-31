package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

    //Counter to keep track of retry attempt
    int minRetryCount=0;

    //The max limit to retry running of failed test cases
    //Set the value to the number of times we want to retry
    int maxRetryCount=2;

    //Method to attempt retries for failure tests
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!(iTestResult.isSuccess()))
        {
            if(minRetryCount<=maxRetryCount)
            {
                minRetryCount=minRetryCount+1;
                return true;
            }
        }
        return false;
    }
}
