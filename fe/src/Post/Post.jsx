import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { gql, useQuery, useMutation } from '@apollo/client';

import './css/Post.css';
import PostInfo from './components/PostInfo';
import Tags from '../components/Tags';
import PostDesc from './components/PostDesc';
import CommentList from './components/CommentList';
import Liked from './components/Liked';

const GET_POST = gql`
  query getPost($postId: Int!) {
    findPostByPostId(id: $postId) {
      postId
      userName
      content
      title
      mainCategoryNumber
      categoryList
      createdDate
      views
      hearts
    }
  }
`;

// 좋아요 상태 업데이트
const SET_LIKED = gql`
  mutation setLiked($heartRequest: heartRequestDto!) {
    updateHeartState(heartRequestDto: $heartRequest)
  }
`;

// 게시물 삭제
const DELETE_POST = gql`
  mutation delete($postId: Int!) {
    deletePost(postId: $postId)
  }
`;

const Post = function () {
  const navigate = useNavigate();
  // const { id } = useParams();
  const id = 1;
  const { data, loading, error } = useQuery(GET_POST, {
    variables: {
      postId: id,
    },
  });
  console.log(data);
  const [updateHeartState] = useMutation(SET_LIKED, {
    onCompleted: (result) => {
      console.log(result);
    },
  });
  const [deletePost] = useMutation(DELETE_POST, {
    onCompleted: (result) => {
      console.log(`게시물 삭제 결과 => ${result}`);
    },
  });
  const [active, setActive] = useState(false);
  const onClick = () => {
    setActive(!active);
    updateHeartState({
      variables: {
        heartRequest: {
          postId: id,
          userId: 1,
          isHeart: active,
        },
      },
    });
  };
  const onDelete = () => {
    deletePost({
      variables: {
        postId: id,
      },
    });
    navigate(-1); // 삭제 시 이전 페이지로 이동
  };
  if (loading) return <p>loading</p>;
  if (error) return <p>ERR_CONNECTION_REFUSED</p>;
  return (
    <div className="post">
      <div className="post-middle">
        <span className="post__title">{data.findPostByPostId.title}</span>
        <PostInfo
          author={data.findPostByPostId.userName}
          date={data.findPostByPostId.createdDate}
          views={data.findPostByPostId.views}
          hearts={data.findPostByPostId.hearts}
          onDelete={onDelete}
        />
        <Tags tags={data.findPostByPostId.categoryList} />
        <PostDesc />
        <Liked active={active} setActive={onClick} />
      </div>
      <div className="post-partition" />
      <CommentList />
    </div>
  );
};

export default Post;
