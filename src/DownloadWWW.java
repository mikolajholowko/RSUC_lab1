import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DownloadWWW {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader((
                        new URL("https://plk.pl/terminarz-i-wyniki.html").openStream())));
        //in.lines().forEach(System.out::println);
        String pageContent = in.lines().collect(Collectors.joining("\n"));

        String regexHomeTeams = "<span itemprop=\"homeTeam\".*>(.*)</span>";
        //  String regexAwayTeams = "<span itemprop=\"awayTeam\".*>(.*)</span>";
        Pattern pattern = Pattern.compile(regexHomeTeams);
        // Pattern pattern2 = Pattern.compile(regexAwayTeams);
        Matcher matcher = pattern.matcher(pageContent);
        //  Matcher matcher2 = pattern2.matcher(pageContent);

        System.out.println("Wybierz drużynę (np. \"Czarni Słupsk\"):");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedTeam = reader.readLine();

        while (matcher.find()) {
            String homeTeam = matcher.group(1);
          //  String awayTeam = matcher2.group(2);
            if (homeTeam.contains(selectedTeam)) {
                System.out.println("HOME TEAM: " + homeTeam + "\n" + "vs" + "\n" + "AWAY TEAM: " + "\n \n \n");
            }
        }
//        Matcher matcher = Pattern.compile("(?:<div.*?class=\"some-class\".*?>)(.*?)(?:<\\/div>)")
//                .matcher("<html><body>Probably.<div class=\"some-class\">data-game</div><br />Today</body></html>");
//        if (matcher.find()) {
//            System.out.println(matcher.group(1)); // prints [Hello, world!]
//        }


    }
}
