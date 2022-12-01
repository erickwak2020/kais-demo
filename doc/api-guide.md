REST API 설계 시 가장 중요한 항목은 다음의 2가지로 요약할 수 있습니다.
> 첫 번째,  URI는 정보의 자원을 표현해야 한다.

> 두 번째,** 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현한다.

## 1) URI는 정보의 자원을 표현해야 한다. (리소스명은 동사보다는 명사를 사용)
`GET /members/delete/1`
위와 같은 방식은 REST를 제대로 적용하지 않은 URI입니다. URI는 자원을 표현하는데 중점을 두어야 합니다.
delete와 같은 행위에 대한 표현이 들어가서는 안된다.
## 2) 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE 등)로 표현
위의 잘못 된 URI를 HTTP Method를 통해 수정해 보면
`DELETE /members/1`
으로 수정할 수 있다.
회원정보를 가져올 때는 GET, 회원 추가 시의 행위를 표현하고자 할 때는 POST METHOD를 사용하여 표현한다.
### 회원정보를 가져오는 URI
```
    GET /members/show/1     (x)
    GET /members/1          (o)
```
### 회원을 추가할 때

```
    GET /members/insert (x)  - GET 메서드는 리소스 생성에 맞지 않는다.
    POST /members       (o)
```

[참고]HTTP METHOD의 알맞은 역할**POST, GET, PUT, DELETE 이 4가지의 Method를 가지고 CRUD를 한다.
다음과 같은 식으로 URI는 자원을 표현하는 데에 집중하고 행위에 대한
정의는 HTTP METHOD를 통해 하는 것이 REST한 API를 설계하는 중심 규칙이다.

## URI 설계 시 주의할 점

### 1) 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용
    http://restapi.example.com/houses/apartments
    http://restapi.example.com/animals/mammals/whales
### 2) URI 마지막 문자로 슬래시(/)를 포함하지 않는다.
URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 URI가 다르다는 것은 리소스가 다르다는 것이고,
역으로 리소스가 다르면 URI도 달라져야 합다 .
REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 슬래시(/)를 사용하지 않는다.
http://restapi.example.com/houses/apartments/ (X)
http://restapi.example.com/houses/apartments  (0)
### 3) 하이픈(-)은 URI 가독성을 높이는데 사용
URI를 쉽게 읽고 해석하기 위해, 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높일 수 있다.
### 4) 밑줄(_)은 URI에 사용하지 않는다.
글꼴에 따라 다르긴 하지만 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 한다.
이런 문제를 피하기 위해 밑줄 대신 하이픈(-)을 사용하는 것이 좋다.(가독성)
### 5) URI 경로에는 소문자가 적합하다.
URI 경로에 대문자 사용은 피하도록 한다.
대소문자에 따라 다른 리소스로 인식하게 되기 때문입니다.
RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정하기 때문이지요.
> RFC 3986 is the URI (Unified Resource Identifier) Syntax document
### 파일 확장자는 URI에 포함시키지 않는다.
    http://restapi.example.com/members/soccer/345/photo.jpg (X)
REST API에서는 메시지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다.
Accept header를 사용하도록 한다.
`GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg`

## 리소스 간의 관계를 표현하는 방법**

REST 리소스 간에는 연관 관계가 있을 수 있고, 이런 경우 다음과 같은 표현방법으로 사용한다.
/리소스명/리소스 ID/관계가 있는 다른 리소스명

    ex)    GET : /users/{userid}/devices (일반적으로 소유 ‘has’의 관계를 표현할 때)
만약에 관계명이 복잡하다면 이를 서브 리소스에 명시적으로 표현한다.
예를 들어 사용자가 ‘좋아하는’ 디바이스 목록을 표현해야 할 경우 다음과 같은 형태로 사용한다.
GET : /users/{userid}/likes/devices (관계명이 애매하거나 구체적 표현이 필요할 때)

## 자원을 표현하는 Collection 과 Document
Collection과 Document에 대해 알면 URI 설계가 한 층 더 쉬워집니다. 
DOCUMENT는 단순히 문서로 이해해도 되고, 한 객체라고 이해하셔도 될 것 같습니다. 
컬렉션은 문서들의 집합, 객체들의 집합이라고 생각하시면 이해하시는데 좀더 편하실 것 같습니다. 
컬렉션과 도큐먼트는 모두 리소스라고 표현할 수 있으며 URI에 표현됩니다. 예를 살펴보도록 하겠습니다.
http:// restapi.example.com/sports/soccer
위 URI를 보시면 sports라는 컬렉션과 soccer라는 도큐먼트로 표현되고 있다고 생각하면 됩니다. 좀 더 예를 들어보자면
http://restapi.example.com/sports/soccer/players/13

sports, players 컬렉션과 soccer, 13(13번인 선수)를 의미하는 도큐먼트로 URI가 이루어지게 됩니다. 
여기서 중요한 점은 **컬렉션은 복수**로 사용하고 있다는 점입니다. 
좀 더 직관적인 REST API를 위해서는 컬렉션과 도큐먼트를 사용할 때 단수 복수도 지켜준다면 좀 더 이해하기 쉬운 URI를 설계할 수 있다.

## HTTP 응답 상태 코드


