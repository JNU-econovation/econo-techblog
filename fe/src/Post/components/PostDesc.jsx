import React from 'react';

import '../css/PostDesc.css';

const PostDesc = function () {
  return (
    <div className="post-desc">
      React 리팩토링, 10년 넘은 리디북스 웹도 OK 프론트엔드 기술 스택 대통합
      준희 한 2021년 12월 20일 리디북스 프론트엔드 웹을 개발하는 한준희라고
      합니다. 처음 입사해 직접 코드를 봤을 때 무척 놀랐어요. 10년이나 된
      서비스라 오래된 코드도 많았거든요. 그걸 새롭게 바꾸려 한 시도 역시
      지층처럼 고스란히 쌓여있었고요. 프론트엔드 기술 스택을 하나로 통합하는
      React 리팩토링 프로젝트, 지금부터 소개합니다. 리액트에 진심인 개발자 영상
      시리즈 ▼ RIDIBOOKS web 1부 RIDIBOOKS web 2부 프론트엔드 기술 통합 React
      리팩토링 프론트엔드 기술 스택을 하나로 통합하는 “리팩토링(refactoring)
      프로젝트”를 시작했습니다. 핵심 목적은 생산성과 유지보수성이었어요.
      디자인은 그대로 유지하지만, 구현은 완전히 새로 개발하는 것이 골자였습니다.
      리액트를 리팩토링하는 것이 가장 효율적이라고 판단했어요. 리액트가 기존
      리디북스에서 가장 높은 비중을 차지하고 있었기 때문입니다. 기존에는 여러
      프론트엔드 팀이 각각의 도메인에 해당하는 프론트엔드를 운영했었습니다.
      그래서 어떤 서비스는 아예 기술 스택이 다르기도 했고, 스택은 같지만
      컨벤션이 전혀 다른 경우도 있었어요. 하지만 이번 기회로 리디의 전체 서비스
      기술은 대동단결하게 되었습니다. 앱은 React-Native로, 웹은 React로 말이죠.
      저를 포함해 총 5명의 프론트엔드 엔지니어가 프로젝트를 진행하고 있습니다.
      당연히 비즈니스 피처 개발이 우선순위가 높기에, 피처 개발 약 60%, 리팩토링
      40% 의 비중으로 운영하고 있어요. 새롭게 개발하거나 기존 페이지를 수정해야
      하는 경우, 되도록 리팩토링도 같이 진행하려 하고요. React 장단점? jsx
      문법과 component frontend view library - Angular, Vue, React front-end
      view library 처음 이런 프론트엔드 뷰 라이브러리를 접했던 건
      앵귤러(Angular)였어요. 그때 접한 앵귤러의 문법은 서버사이드의 문법과
      비슷하다고 느꼈는데요. 렌더와 액션을 처리하는 부분이 template와
      controller로 나뉜 구조죠. 하지만 리액트는 jsx 문법으로, 한 파일 안에서
      렌더와 액션 모두를 한눈에 보며 개발할 수 있어서 좋았어요. 특히 jsx 문법과
      그 당시 리액트가 보여주었던 빠른 퍼포먼스에 반했던 기억이 나요. 반대로
      리액트의 단점으로 생각하는 부분도 있는데, 지금은 많이 개선되었어요. 먼저,
      타입스크립트가 없었을 때는 propTypes로 처리하다 보니 여러 가지로
      불편했어요. 다행히 타입스크립트를 도입하고 나서는 타입 관련 문제들이 거의
      해결되었습니다. 또, class component로 개발할 때는 라이프사이클 관리가
      비교적 쉬웠는데요. 상태 변화에 따른 최적화, componentWillUpdate와 같은
      메소드, (지금은 다른 함수로 대체되었지만) 컴포넌트 상태가 변경될 때
      최적화에 손이 참 많이 갔었죠. 지금은 모두 function component로 개발하고
      있습니다. 훅을 통해 거의 모든 걸 구현할 수 있어 코드를 간결하고 직관적으로
      짤 수 있고, 커스텀 훅으로 재사용성도 높아지게 되었는데요. 하지만 더
      복잡해진 면도 있다고 생각해요. useEffect를 사용하면서 말 그대로
      사이드이펙트에서 한 번 더 고려해야 하고, 상태에 따른 최적화를 위해
      useRef나 useMemo를 사용하니까요. 또 상태관리 라이브러리를 도입하고 SSR을
      위해 Next.js를 도입하는 등 이것저것 필요한 게 많아지죠. 결국 리액트 하나만
      가지고는 아무것도 못한다는 것. 그게 아이러니인 것 같아요.
    </div>
  );
};

export default PostDesc;
