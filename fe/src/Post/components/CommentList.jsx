import React from 'react';

import '../css/CommentList.css';

import Comment from './Comment';
import CommentBox from './CommentBox';

const result = [
  {
    id: 1,
    name: '김수민',
    desc: '안녕하세요 궁금한점이 있습니다! 만약에 사용자가 빌린 차를 세차한 것이 아니라 구글링이나 다른 자동차를 세차한 이미지를 올린다면 이건 어떤 방식으로 걸러내는 건가요?',
  },
  {
    id: 2,
    name: '김수민',
    desc: '안녕하세요 궁금한점이 있습니다! 만약에 사용자가 빌린 차를 세차한 것이 아니라 구글링이나 다른 자동차를 세차한 이미지를 올린다면 이건 어떤 방식으로 걸러내는 건가요?',
  },
  {
    id: 3,
    name: '김수민',
    desc: '안녕하세요 궁금한점이 있습니다! 만약에 사용자가 빌린 차를 세차한 것이 아니라 구글링이나 다른 자동차를 세차한 이미지를 올린다면 이건 어떤 방식으로 걸러내는 건가요?',
  },
];

const CommentList = function () {
  return (
    <div className="comment-list">
      <span className="comment-list__num">{`댓글 ${result.length}개`}</span>
      <CommentBox />
      {result.map((comment) => (
        <Comment key={comment.id} name={comment.name} desc={comment.desc} />
      ))}
    </div>
  );
};

export default CommentList;
