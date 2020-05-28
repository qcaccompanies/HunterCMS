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

WebUI.click(findTestObject('Object Repository/Christi/Page_Main/img_Manage Gamification_picture8'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/button_Tambah Reward IconTambah Reward'))

WebUI.setText(findTestObject('Object Repository/Christi/Page_Dashboard/input_Reward_text1'), nama_reward)

WebUI.setText(findTestObject('Object Repository/Christi/Page_Dashboard/textarea_Deskripsi_textarea1'), desc_reward)

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/span_Tambah Reward'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/button_Simpan'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/div_Add Master Reward Success'))

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/label_Delete'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/label_Apakah Anda yakin ingin menghapus Reward ini'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/button_Hapus'))

WebUI.click(findTestObject('Object Repository/Christi/Page_Dashboard/div_Delete Master Reward Success'))

