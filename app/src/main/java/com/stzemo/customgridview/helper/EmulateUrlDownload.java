package com.stzemo.customgridview.helper;

import com.stzemo.customgridview.models.Person;

import java.util.ArrayList;
import java.util.List;

public class EmulateUrlDownload {
    private static List<Person> list;
    private static String[] urls = {
            "http://akns-images.eonline.com/eol_images/Entire_Site/2016311/rs_600x600-160411063250-600.gilmore-girls-revival-netflix-5.ch.041116.jpg",
            "https://ae01.alicdn.com/kf/HTB1sh4XHVXXXXamaXXXq6xXFXXXY/Wholesales-Designer-Metal-font-b-Frame-b-font-font-b-Girls-b-font-Round-Glasses-Clear.jpg",
            "http://stylesweekly.com/wp-content/uploads/2015/12/fashionable-teenage-girl-hairstyles-1.jpg",
            "http://67.media.tumblr.com/6ef49c9a7a0d751012a180bd914124d9/tumblr_nztrldJs9j1v1hujco1_500.jpg",
            "https://thechive.files.wordpress.com/2016/03/april-is-a-country-girl-we-can-14.jpg?quality=85&strip=info&w=600",
            "http://www.minnesotacountry.com/wp/assets/RacheleLynae.jpg",
            "https://4.bp.blogspot.com/-gN4l5awJVCM/V7Xy9ol0apI/AAAAAAABBSw/SgvZ8b15ujUQYqbVfOXD3LbJ_7b4Li6TgCEw/s1600/girls_with_guns_D1tagkvoo1_540.jpg",
            "https://thechive.files.wordpress.com/2016/07/get-back-in-the-game-with-some-sexy-girls-in-sports-bras-30-photos-27-e1469463934380.jpg?quality=85&strip=info&w=600&h=450&crop=1",
            "https://thechive.files.wordpress.com/2016/03/12660230_1648319335430513_148360741_n.jpg?quality=85&strip=info&w=600",
            "http://cdn2.bigcommerce.com/n-nr1m3w/pqndnq/products/1740/images/8732/S96956_a__91178.1401480782.800.800.jpg?c=2",
            "https://thechive.files.wordpress.com/2016/03/april-is-a-country-girl-we-can-201.jpg?quality=85&strip=info&w=600",
            "http://www.allteenstalk.com/wp-content/uploads/2015/08/girls-in-hot-pants-15.jpg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSlcyqhiVFFD3Thl-EJTLLDk8pjC2HYAWVFcgu8L-NCeZzPLGG9",
            "https://s-media-cache-ak0.pinimg.com/564x/74/f5/b0/74f5b0fdf3af128d06ffa9c130450b76.jpg"
    };

    private static String urlNoPhotos = "https://pp.vk.me/c608828/v608828864/2f15/CddVDKtZqug.jpg";

    static {
        list = new ArrayList();

        for (int i = 0; i < urls.length; i++) {
            Person p = new Person();
            p.urlPhoto = urls[i];
            list.add(p);
        }
    }

    public static String getNoHoney(){
        return urlNoPhotos;
    }

    public static List<Person> getList() {
        return list;
    }
}
