package com.baotianqi.valpromise.http;

/**
 * 作者：junj
 * 时间：2017/1/5 17:35
 * 描述：TOTO
 */
public interface ProgressListener {
    /**
     * @param progress     已经下载或上传字节数
     * @param total        总字节数
     * @param done         是否完成
     */
    void onProgress (long progress, long total, boolean done);
}
