import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { gql, useQuery, useMutation } from '@apollo/client';
/* eslint-disable object-shorthand */

import './css/Post.css';
import PostInfo from './components/PostInfo';
import Tags from '../components/Tags';
import PostDesc from './components/PostDesc';
import CommentList from './components/CommentList';
import Liked from './components/Liked';

const GET_POST = gql`
  query getPost($postId: Int!, $userId: Int!) {
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
    isHeart(postId: $postId, userId: $userId)
  }
`;

// 좋아요 상태 업데이트
const SET_LIKED = gql`
  mutation updateHeartState($heartRequest: HeartRequestDto!) {
    updateHeartState(heartRequestDto: $heartRequest)
  }
`;

// 게시물 삭제
const DELETE_POST = gql`
  mutation deletePost($postId: Int!) {
    deletePost(postId: $postId)
  }
`;

const Post = function () {
  const navigate = useNavigate();
  const { id } = useParams();
  const { data, loading } = useQuery(GET_POST, {
    variables: {
      postId: id,
      userId: 1,
    },
  });
  console.log('findPostByPostId', data);
  const [updateHeartState] = useMutation(SET_LIKED, {
    // eslint-disable-next-line no-shadow
    update(cache, { data: { updateHeartState } }) {
      const { findPostByPostId } = cache.readQuery({
        query: GET_POST,
        variables: {
          postId: id,
          userId: 1,
        },
      });
      const nowPost = { ...findPostByPostId };
      if (updateHeartState > nowPost.hearts) {
        nowPost.hearts += 1;
        cache.writeQuery({
          query: GET_POST,
          variables: {
            postId: id,
            userId: 1,
          },
          data: { findPostByPostId: nowPost, isHeart: true },
        });
      } else {
        nowPost.hearts -= 1;
        cache.writeQuery({
          query: GET_POST,
          variables: {
            postId: id,
            userId: 1,
          },
          data: { findPostByPostId: nowPost, isHeart: false },
        });
      }
    },
  });
  const [deletePost] = useMutation(DELETE_POST, {
    onCompleted: () => {
      navigate(-1); // 삭제 시 이전 페이지로 이동
    },
  });
  const onClick = (active) => {
    updateHeartState({
      variables: {
        heartRequest: {
          postId: id,
          userId: 1,
          isHeart: !active,
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
  };
  if (loading) return null;
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
        <Liked active={data.isHeart} setActive={() => onClick(data.isHeart)} />
      </div>
      <div className="post-partition" />
      <CommentList />
    </div>
  );
};

export default Post;
