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

WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), questionBefore)

WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

WebUI.delay(7)

WebUI.click(findTestObject('Rizka/FAQ Management/btnSettings'))

WebUI.click(findTestObject('Rizka/FAQ Management/btnEdit'))

WebUI.delay(3)

WebUI.setText(findTestObject('Rizka/FAQ Management/inputEditQuestion'), questionAfter)

WebUI.setText(findTestObject('Rizka/FAQ Management/inputEditAns'), answer)

if (condition == 'passed') {
    WebUI.click(findTestObject('Rizka/FAQ Management/btnSimpanEdit'))

    WebUI.delay(5)

    WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), '')

    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    if (questionAfter != '') {
        WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), questionAfter)
    } else {
        WebUI.setText(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), questionBefore)
    }
    
    WebUI.sendKeys(findTestObject('Rizka/FAQ Management/inputSearchFAQ'), Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Rizka/FAQ Management/btnSettings'))

    WebUI.click(findTestObject('Rizka/FAQ Management/btnEdit'))

    atribut1 = WebUI.getAttribute(findTestObject('Rizka/FAQ Management/inputEditQuestion'), 'value')

    atribut2 = WebUI.getAttribute(findTestObject('Rizka/FAQ Management/inputEditAns'), 'value')

    if (questionAfter == '') {
        WebUI.verifyNotMatch(atribut1, questionAfter, false)
    } else {
        WebUI.verifyMatch(atribut1, questionAfter, false)
    }
    
    if (answer == '') {
        WebUI.verifyNotMatch(atribut2, answer, false)
    } else {
        WebUI.verifyMatch(atribut2, answer, false)
    }
} else if (condition == 'cancel') {
    WebUI.delay(5)

    WebUI.click(findTestObject('Rizka/FAQ Management/btnCancelEdit'))

    WebUI.verifyTextNotPresent(questionAfter, false)
}

