/*테스트 수정*/ 
def DSR_SEQ = parm['DSR_SEQ']
def WARD_ID = parm['WARD_ID']

def query = String.format(
		"""
			UPDATE TEST_TABLE SET WARD_ID = '$WARD_ID' WHERE DSR_SEQ = '$DSR_SEQ'
		""",
		WARD_ID, DSR_SEQ);
			
return query