/*테스트 삭제*/ 
def DSR_SEQ = parm['DSR_SEQ']

def query = String.format(
		"""
			DELETE FROM TEST_TABLE WHERE DSR_SEQ = '$DSR_SEQ'
		""",
		DSR_SEQ);
			
return query