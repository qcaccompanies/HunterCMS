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

WebUI.click(findTestObject('Object Repository/Christi/Page_Main/img_Manage Gamification_picture8'))

WebUI.delay(3)

WebUI.click(findTestObject('Christi/Page_1590717297462/Element_1590717331882'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/label_Reset Image'))

not_run: if (img_upload == 'yes') {
    WebUI.uploadFile(findTestObject('Christi/Page_Dashboard/input_Reward_files'), img_reward)

    if (alert == 'file to big') {
        WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/div_File size exceeded limit Max upload size is 03MB'), 
            0)
    } else if (alert == 'wrong file extension') {
        WebUI.verifyElementPresent(findTestObject('Christi/Page_Dashboard/div_Expected file extension is jpegjpgpng'), 0)
    }
}

not_run: WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/button_Simpan_Edit'))

not_run: WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/close_edit_reward dialog'))

