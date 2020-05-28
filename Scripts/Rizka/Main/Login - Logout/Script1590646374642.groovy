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

WebUI.openBrowser('https://appsrv1.deltadatamandiri.com/ACC_Hunter_Web/#/S19n1n')

WebUI.maximizeWindow()

WebUI.delay(15)

WebUI.setText(findTestObject('Rizka/FAQ Management/inputUsername'), username)

WebUI.setText(findTestObject('Rizka/FAQ Management/inputPassword'), password)

WebUI.click(findTestObject('Rizka/FAQ Management/btnEyePass'))

WebUI.click(findTestObject('Rizka/FAQ Management/btnSignIn'))

if (condition == 'passed') {
    WebUI.delay(10)

    WebUI.verifyElementVisible(findTestObject('Rizka/FAQ Management/label_Menu'))
} else if (condition == 'logoutPassed') {
    WebUI.delay(10)

    WebUI.click(findTestObject('Rizka/FAQ Management/btnLogout'))

    WebUI.delay(5)

    WebUI.verifyElementVisible(findTestObject('Rizka/FAQ Management/textLandingPageSignIn'))
} else {
    WebUI.verifyElementVisible(findTestObject('Rizka/FAQ Management/alertGagalLogin'))
}

