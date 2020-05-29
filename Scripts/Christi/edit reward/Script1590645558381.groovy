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

WebUI.callTestCase(findTestCase('Christi/Login'), [('username') : 'admin@mail.com', ('password') : 'Password1#'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Christi/Page_Main/img_Manage Gamification_picture8'))

WebUI.delay(3)

WebUI.click(findTestObject('Christi/Page_Dashboard/img_Jam dinding_picture5'))

switch (edit.toString()) {
    case 'nama reward':
        if (nama_reward_baru == 'erase') {
            WebUI.clearText(findTestObject('Christi/Page_Dashboard/input_edit _nama_reward'))
        } else {
            WebUI.clearText(findTestObject('Christi/Page_Dashboard/input_edit _nama_reward'))

            WebUI.setText(findTestObject('Christi/Page_Dashboard/input_edit _nama_reward'), nama_reward_baru)
        }
        
        break
    case 'img upload':
        if (img_upload == 'erase') {
            WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/label_Reset Image'))
        } else if (img_upload == 'yes') {
            WebUI.delay(3)

            WebUI.uploadFile(findTestObject('Christi/Page_Dashboard/input_Reward_files'), img_reward)

            if (alert == 'file to big') {
                WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/div_File size exceeded limit Max upload size is 03MB'), 
                    0)
            } else if (alert == 'wrong file extension') {
                WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/div_Expected file extension is jpegjpgpng'), 
                    0)
            }
        }
        
        break
    case 'decs reward':
        if (desc_reward_baru == 'erase') {
            WebUI.clearText(findTestObject('Christi/Page_Dashboard/textarea_edit_deskripsi_reward'))
        } else {
            WebUI.setText(findTestObject('Christi/Page_Dashboard/textarea_edit_deskripsi_reward'), desc_reward_baru)
        }
        
        break
}

WebUI.delay(3)

WebUI.click(findTestObject('Christi/Page_Dashboard/span_Simpan'))

if (expected == 'pass') {
    if (edit == 'nama reward') {
        WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/nama reward', [('text') : nama_reward_baru]), 
            0)
    } else {
        WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/nama reward', [('text') : nama_reward]), 0)
    }
} else if (expected == 'fail') {
    switch (alert.toString()) {
        case 'nama kosong':
            WebUI.delay(3)

            WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/p_Nama tidak boleh kosong'), 3)

            WebUI.delay(3)

            break
        case 'deskripsi kosong':
            WebUI.delay(3)

            WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/p_Deskripsi tidak boleh kosong'), 3)

            WebUI.delay(3)

            break
    }
}

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

