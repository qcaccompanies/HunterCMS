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

WebUI.callTestCase(findTestCase('Rizka/MainLogin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Rizka/FAQ Management/btnFAQManagement'))

WebUI.delay(7)

WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), namaFAQ)

WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

WebUI.delay(7)

WebUI.click(findTestObject('Rizka/FAQ Management/btnSettings'))

if (condition == 'passed') {
    WebUI.click(findTestObject('Rizka/FAQ Management/btnDelete'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Rizka/FAQ Management/btnHapus'))

    WebUI.delay(5)

    WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), '')

    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), namaFAQ)

    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    WebUI.verifyElementPresent(findTestObject('Rizka/FAQ Management/alertNotFound'), 0)
} else {
    WebUI.click(findTestObject('Rizka/FAQ Management/btnDelete'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Rizka/FAQ Management/btnCancelHapus'))

    WebUI.delay(5)

    WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), '')

    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), namaFAQ)

    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    WebUI.verifyElementNotPresent(findTestObject('Rizka/FAQ Management/alertNotFound'), 0)
}

