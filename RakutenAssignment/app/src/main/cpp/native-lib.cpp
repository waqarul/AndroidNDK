#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_waqar_rakutenassignment_MainActivity_countUpFromJNI(JNIEnv *env, jobject instance, jint value) {

    char *szFormat = "%i";
    char *szResult;

    // add the two values
    jlong countUp = value + 1;

    // malloc room for the resulting string
    szResult = static_cast<char *>(malloc(sizeof(szFormat)));

    // standard sprintf
    sprintf(szResult, szFormat, countUp);

    // get an object string
    jstring result = env->NewStringUTF(szResult);

    // cleanup
    free(szResult);

    return result;

}


// anouther way to sum up

extern "C"
JNIEXPORT jlong JNICALL
Java_com_waqar_rakutenassignment_MainActivity_countUpFromJNIShortVersion(JNIEnv *env, jobject instance,
                                                         jint value) {

    jlong countUp = value + 1;

    return countUp;
}