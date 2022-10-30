/**
 * 
 */

//api authURL : URL을 상수로 선언. 보통은 properies에 선언하여 사용함
let apiURL = 'http://apis.data.go.kr/4050000/nrsry/getNrsry';

//api authKey : 인증키를 상수로 선언. 보통은 properies에 선언하여 사용함
let apiKey = 'mYPOIgt0L3N2B%2F1V6eSQ%2BgFFUqxeCzZmVmC%2F2xxyUHV%2BmoYjihAMaJKssAh%2BV7JByUfIjGc5XQL1a7AkC4c7Zg%3D%3D';

$(document).ready(function(){      
	var api = new Vue ({
		el : "#api",
		data : {
			apiList : [], // api를 통해 가져온 json 데이터를 담아서 화면에 뿌려주도록 함
			pageNo : '', // api의 필수 파라메터 값 1
			numOfRows : '', //api의 필수 파라메터 값 2
			nrsryType : '' // 어린이집 유형 파라메터
		},
		mounted(){
			this.pageNo = '3', // mounted되었을 때 페이지번호 초기값 설정 
			this.numOfRows = '5', // mounted되었을 때 한페이지에 표시할 행 초기값 설정
			this.search(); // mounted되었을 때 search 함수를 호출해 api를 호출함
		},
		methods : {
			search : function(){
				var self = this;
				var config = {headers: {"Accept": "*/*",}}; // header를 변수로 선언
				/*
				 * url를 선언함. 여기서는 그냥 대충 짰지만, 실제 사용할 때는 URL작성이 조금 더 동적이면서 유연하게 작성 할 필요가 있음
				 * */
				var url = 'https://cors-anywhere.herokuapp.com/'+ apiURL + '?serviceKey=' +apiKey + '&pageNo=' + this.pageNo + '&numOfRows=' + this.numOfRows
				+ '&nrsry_type=' + this.nrsryType;
				axios.get(url,'',config).then(function(reult) { // url호출 -> 공공데이터포털로 데이터 요청을 보낸다. (request)
					self.apiList = result.data.items; // 서버통신 성공시 apiList 배열에 해당 값을 담음 ( response )
				})
			},
		}
	});
 })