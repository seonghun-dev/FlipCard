//User
public class User {
   public static String Userinfo[] = new String[4]; // 유저배열
   private static int indexofColorID = 1; // 현재사용자의 컬러값
   public static String myname; // 현재 나의 이름 값

   // 현재 사용자 변경
   public void ChangeCurrentUser(String UserID, String Color) {
      switch (Color) {
      case "BROWN":
         Userinfo[0] = UserID;
         break;
      case "BLUE":
         Userinfo[1] = UserID;
         break;
      case "PINK":
         Userinfo[2] = UserID;
         break;
      case "GREEN":
         Userinfo[3] = UserID;
         break;
      }
   }

   // 사용자 본인의 색상값 확인.
   public void GetMyuserColor(String UserID) {
      for (int i = 0; i < 4; i++) {
         if (Userinfo[i] == UserID) {
            indexofColorID = i + 1;
            break;
         }
      }
   }

   // 사용자 본인 색상 가져오기
   public int GetMyColor() {
      return indexofColorID;
   }

   // 사용자 본인 이름값 반환
   public String GetMyname() {
      return myname;
   }

}