//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class testV1 {
//
//        public static void main(String[] args) {
//            try {
//                // Pobieranie danych ze strony
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        new URL("https://plk.pl/terminarz-i-wyniki.html").openStream()));
//                String pageContent = in.lines().collect(Collectors.joining("\n"));
//
//                // Wyrażenie regularne do wyłuskania terminów spotkań
//                String regex = "<a class=\"match-item\".*?>(.*?)</a>";
//                Pattern pattern = Pattern.compile(regex);
//                Matcher matcher = pattern.matcher(pageContent);
//
//                // Wybieranie drużyny
//                System.out.println("Wybierz drużynę (np. \"Czarni Słupsk\"):");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                String selectedTeam = reader.readLine();
//
//                // Wyświetlanie terminów spotkań dla wybranej drużyny
//                while (matcher.find()) {
//                    String matchInfo = matcher.group(1);
//                    if (matchInfo.contains(selectedTeam)) {
//                        System.out.println(matchInfo);
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//
