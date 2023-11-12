# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항 정리
* 입력 받은 문자를 공백 기준으로 나누어야 한다.
* 나눗셈의 결과는 무조건 int 형입니다. 만약 음수 -2.6 이 나온다고 하면 -2를 반환합니다.
* 사칙연산이 아닌 앞에서부터 차례로 계산합니다.

## step1
* readme.md 파일에 요구사항 정리
* 도메인 별 테스트 코드 및 구현체 작성
  * BlankSeparator : StringCalculator 도메인을 만들어줍니다.
  * StringCalculator : 내부에 연산자 리스트와 숫자 리스트를 갖고 해당 클래스에게 연산을 맡깁니다.
  * Operator : 실제 연산을 진행하는 Enum 클래스 입니다.

## step2
* 요구사항 정리
* 구입금액은 1000의 배수여야 합니다.
* 입력받은 당첨 번호 중 1보다 작거나 45보다 큰 수가 있으면 안됩니다.
* 수익률은 총 당첨 금액 / 구입금액 입니다.
* 수익률은 소수 2째자리까지 구하며 그 이후는 버림 처리합니다.
* 상금은 3개 일치 : 5000 / 4개 일치 : 50000 / 5개 일치 : 1500000 / 6개 일치 : 2000000000 입니다.