import java.util.Arrays;

public class Cookies {
  
  public static int cookiesToChildren(int[] children, int[] cookies) {
    /*
    I could have delcared cookiesGiven here but that would allocate memory 
    that isn't needed if the if statement below is true
    */
    if(children.length < 1 || cookies.length < 1) {
      return 0;
    }
    
    /*
    I am sorting the arrays so a child that could pontetially get a cookie doesn't 
    get skipped over because another child with a higher greed factor takes it
    for example, if you have the two arrays below, then the first child(5) will take 
    the first cookie(1) in the cookies array and thus it will cause the last child(1) 
    to not get a cookie, by sorting them you rectify this potential issue
    int[] children = {5,4,3,2,1};
    int[] cookies = {1,2,3,4,6};
    */
    Arrays.sort(children);
    Arrays.sort(cookies);
    
    int cookiesGiven = 0; // number of cookies in total given out to children
    int cookieIndex = 0; // pointer for cookie array
    int cookieLen = cookies.length - 1; // last index of cookie array
    
    /* loop over both the children array and the cookies array and stop once you have
    reached the end of one of the arrays if they are not the same length
    */
    for(int i = 0; i < children.length; i++) {
      // if we run out of cookies (reach the end of the cookie array)
      if(cookieIndex > cookieLen) {
        break;
      }
      if(children[i] >= cookies[cookieIndex]) {
        cookiesGiven++; // increment to increase the cookies given out to children 
        cookieIndex++; // increment to move on to the next cookies element
      }
    }
    
    return cookiesGiven;
  }
  
  
  public static void main(String[] args) {
    
    int[] children1 = {5,4,3,2,1};
    int[] cookies1 = {1,2,3,4,6};
    int cookiesDistributed1 = cookiesToChildren(children1, cookies1);
    System.out.printf("Should return 4 and returns %d\n", cookiesDistributed1);
    
    int[] children2 = {5,4,3,2,1};
    int[] cookies2 = {1,1};
    int cookiesDistributed2 = cookiesToChildren(children2, cookies2);
    System.out.printf("Should return 2 and returns %d\n", cookiesDistributed2);
    
    int[] children3 = {};
    int[] cookies3 = {1,1};
    int cookiesDistributed3 = cookiesToChildren(children3, cookies3);
    System.out.printf("Should return 0 and returns %d\n", cookiesDistributed3);
    
    int[] children4 = {5,4,3,2,1};
    int[] cookies4 = {};
    int cookiesDistributed4 = cookiesToChildren(children4, cookies4);
    System.out.printf("Should return 0 and returns %d\n", cookiesDistributed4);
    
  }
}
