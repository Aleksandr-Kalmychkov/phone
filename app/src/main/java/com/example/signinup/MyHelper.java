package com.example.signinup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyHelper {
    public static ArrayList<String> Urls;

public static void fill()
{
    Urls = new ArrayList<>();
    Urls.add("https://phonoteka.org/uploads/posts/2021-05/thumbs/1621991944_53-phonoteka_org-p-merilin-monro-pop-art-krasivo-60.jpg");
    Urls.add("https://phonoteka.org/uploads/posts/2021-05/thumbs/1621991944_53-phonoteka_org-p-merilin-monro-pop-art-krasivo-60.jpg");
    Urls.add("https://phonoteka.org/uploads/posts/2021-05/thumbs/1621991944_53-phonoteka_org-p-merilin-monro-pop-art-krasivo-60.jpg");
    Urls.add("https://phonoteka.org/uploads/posts/2021-05/thumbs/1621991944_53-phonoteka_org-p-merilin-monro-pop-art-krasivo-60.jpg");
    Urls.add("http://i.imgur.com/DvpvklR.png");
}


    public static boolean checkEmail (String email)
    {
        Pattern pattern = Pattern.compile("^[\\w\\.]+@\\w+\\.\\w+$");
        if (!pattern.matcher(email).find()) return false;
        else return true;
    }

    public static boolean checkPassword (String password)
    {
        Pattern HiLet = Pattern.compile("[A-Z[А-Я]]+");
        Pattern Simb = Pattern.compile("\\W+");
        Pattern Digit = Pattern.compile("\\d+");
        if (!HiLet.matcher(password).find() || !Simb.matcher(password).find() || !Digit.matcher(password).find() || password.length() < 8)
        {
            return false;
        }
        else return true;
    }

    //POST-запрос на вход в аккаунт
    public static String signInPOST(String email, String password, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
        {
            return response.toString();
        }
        else return Integer.toString(response.code());
    }

    //POST-запрос на регистрацию аккаунта
    public static String signUpPOST(String email, String password, String name, String surname, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .add("name", name)
                .add("surname", surname)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200)
        {
            return response.toString();
        }
        else return Integer.toString(response.code());
    }

    //TODO Обработчик ответов API
}
