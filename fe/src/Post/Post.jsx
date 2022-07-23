import React, { useState } from 'react';
// import { useQuery } from '@apollo/client';

import './css/Post.css';
import PostInfo from './components/PostInfo';
import Tags from '../components/Tags';
import PostDesc from './components/PostDesc';
import CommentList from './components/CommentList';
import Liked from './components/Liked';

/*
const GET_POST = gql`
  query getPost($postId: String!) {
    findPostByPostId(id: $postId) {
      id
      userId
      content
      title
      official
      views
      hearts
      mainCategory
    }
  }
`;
*/

const Post = function () {
  // const { id } = useParams();
  // const result = useQuery(GET_POST, {
  //   variables: {
  //     postId: id,
  //   },
  // });
  const [liked, setLiked] = useState(false);
  return (
    <div className="post">
      <div className="post-middle">
        <span className="post__title">
          에코노베이션 멋알팀에서 에코노베이션 기술 블로그를 제작하였습니다.
        </span>
        <PostInfo
          author="에코노베이션"
          date="2022.05.04"
          views="21"
          hearts="21"
        />
        <Tags />
        <PostDesc />
        <Liked liked={liked} setLiked={setLiked} />
      </div>
      <div className="post-partition" />
      <CommentList />
    </div>
  );
};

export default Post;
