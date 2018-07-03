package com.rid.morgan.inter.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.rid.morgan.inter.app.Inter;
import com.rid.morgan.inter.net.callback.IRequest;
import com.rid.morgan.inter.net.callback.ISuccess;
import com.rid.morgan.inter.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Create by Morgan on 2018/7/3 0003
 */
public class SaveFileTask extends AsyncTask<Object,Void,File>{

    public SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;


    @Override
    protected File doInBackground(Object... params) {

        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        ResponseBody responseBody = (ResponseBody) params[2];
        String name = (String) params[3];
        InputStream is = responseBody.byteStream();
        if(downloadDir == null || downloadDir.equals("")){
            downloadDir = "down_loads";
        }
        if(extension == null || extension.equals("")){
            extension = "";
        }
        if(name == null){
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase(),extension);
        }else{
            return FileUtil.writeToDisk(is,downloadDir,name);
        }
    }


    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if(SUCCESS != null){
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null){
            REQUEST.onRequestEnd();
        }
    }

    /**
     * 默认下载完apk自动安装
     * @param file
     */
    private void autoInstallApk(File file){
        if(FileUtil.getExtension(file.getPath()).equals("apk")){
            Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            Inter.getApplicationContext().startActivity(install);
        }
    }
}
