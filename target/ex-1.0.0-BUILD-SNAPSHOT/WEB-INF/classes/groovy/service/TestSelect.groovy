/*테스트 조회*/ 
def DSR_SEQ = parm['DSR_SEQ']

def query = String.format(
		"""
			SELECT '$DSR_SEQ' TEST
			FROM DUAL
		""",
		DSR_SEQ);
			
return query