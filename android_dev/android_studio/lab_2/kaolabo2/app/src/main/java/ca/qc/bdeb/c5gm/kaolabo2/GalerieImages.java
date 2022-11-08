package ca.qc.bdeb.c5gm.kaolabo2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;

public class GalerieImages {

    public static ArrayList<String> listImages(Context context) {
        Uri uri;
        Cursor cursor;
        int colonne_index_data, colonne_index_folder_name;
        ArrayList<String> listImages = new ArrayList<>();
        String absoluteImgPath;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor = context.getContentResolver().query(uri, projection, null, null, "DESC");

        colonne_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        // get older name
        // col

        while (cursor.moveToNext()) {
            absoluteImgPath = cursor.getString(colonne_index_data);
            listImages.add(absoluteImgPath);
        }
        return listImages;


    }

}
