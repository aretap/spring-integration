/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.loanbroker.stubs;

import java.util.Calendar;
import java.util.Random;

import org.springframework.integration.loanbroker.domain.LoanQuote;
import org.springframework.integration.loanbroker.domain.LoanRequest;

/**
 * @author Oleg Zhurakousky
 */
public class BankStub {

	/**
	 * @param loanRequest the loan request
	 * @return a LoanQuote for the given request
	 */
	public LoanQuote quote(LoanRequest loanRequest){
		Calendar calendar = Calendar.getInstance();
		LoanQuote loanQuote = new LoanQuote();
		Random random = new Random();
		loanQuote.setQuoteDate(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, random.nextInt(25));
		loanQuote.setExpirationDate(calendar.getTime());
		loanQuote.setRate(random.nextFloat() + 5);
		loanQuote.setLoanTerm(10 + random.nextInt(10));
		loanQuote.setLoanAmount(250000 + random.nextInt(40000));
		loanQuote.setLender("StubBank-" + random.nextInt(30));
		return loanQuote;
	}

}
