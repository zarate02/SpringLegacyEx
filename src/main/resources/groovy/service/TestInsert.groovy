/*테스트 인서트*/ 
def DSR_SEQ = parm['DSR_SEQ']

def query = String.format(
		"""
			INSERT INTO TEST_TABLE ( DSR_SEQ ) VALUE ('$DSR_SEQ')
		""",
		DSR_SEQ);
			
return query