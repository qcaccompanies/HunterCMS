import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Christi/Login'), [('username') : 'admin@mail.com', ('password') : 'Password1#'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Christi/Page_Main/label_Go to Dashboard'))

WebUI.delay(3)

WebUI.click(findTestObject('Christi/Page_Dashboard/a_Change Password'))

WebUI.delay(3)

if (show_pwd == 'yes') {
    WebUI.click(findTestObject('Christi/Page_Dashboard/img_Testing_eyeOldPassword'))
}

WebUI.setText(findTestObject('Christi/Page_Dashboard/input_Testing_oldPassword'), password)

WebUI.delay(0)

if (show_pwd_baru == 'yes') {
    WebUI.click(findTestObject('Christi/Page_Dashboard/img_Testing_eyePassword'))
}

WebUI.setText(findTestObject('Christi/Page_Dashboard/input_Testing_password'), password_baru)

if (show_pwd_konfir == 'yes') {
    WebUI.click(findTestObject('Christi/Page_Dashboard/img_Testing_eyeConfPassword'))
}

WebUI.setText(findTestObject('Christi/Page_Dashboard/input_Testing_confPassword'), password_konfirmasi)

WebUI.delay(0)

WebUI.click(findTestObject('Christi/Page_Dashboard/span_Change Password'))

if (expected == 'pass') {
    WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/label_Konfirmasi akun anda dengan memasukkan kode verifikasi yang telah dikirim ke nomor handphone anda'), 
        0)

    WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/div_Kode OTP_gridrow24'), 0)

    WebUI.setText(findTestObject('Christi/Page_Dashboard/input_Kode OTP_text1'), '')

    WebUI.click(findTestObject('Christi/Page_Dashboard/button_KONFIRMASI'))

    WebUI.click(findTestObject('Christi/Page_Dashboard/close_confirm_otp_dialog'))

    if (true) {
        WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/label_otp_countDown'), 0)

        WebUI.click(findTestObject('Christi/Page_Dashboard/span_Kirim Ulang OTP'))
    }
} else if (expected == 'fail') {
    switch (status.toString()) {
        case 'wrong pwd criteria':
            break
        case 'password lama salah':
            break
        case 'password lama kosong':
            break
        case 'password baru kosong':
            break
        case 'password konfir kosong':
            break
        case 'pwd baru & pwd konfir beda':
            break
    }
}

WebUI.click(findTestObject('Christi/Page_Dashboard/div_Password lama tidak boleh kosong'))

