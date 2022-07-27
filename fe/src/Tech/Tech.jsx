import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Pagination from 'react-js-pagination';
import { gql, useQuery } from '@apollo/client';

import { useLoginStateContext } from '../Context/LoginContext';
import './css/Tech.css';
import '../components/css/Pagination.css';
import write from './img/write.png';
import Banner from './components/Banner';
import Official from './components/Official';
import PostBox from '../components/PostBox';

const GET_POSTS = gql`
  query findAllPosts($mainCategoryNumber: Int!, $page: Int!) {
    findAllPosts(mainCategoryNumber: $mainCategoryNumber, page: $page) {
      postId
      userName
      content
      title
      mainCategoryNumber
      categoryName
      createdDate
      views
      hearts
    }
  }
`;

const Tech = function () {
  const { category } = useParams();
  const loginContext = useLoginStateContext();
  const [currentPosts, setCurrentPosts] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const { data } = useQuery(GET_POSTS, {
    variables: {
      mainCategoryNumber: category,
      page: currentPage,
    },
  });
  console.log(data);
  const navigate = useNavigate();
  const onClick = () => {
    navigate('/write');
  };
  useEffect(() => {
    if (data) {
      setCurrentPosts(data.findAllPosts);
    }
  }, [data]);
  useEffect(() => {
    // 페이지 바뀌면 스크롤 맨위로 이동
    window.scrollTo(0, 0);
  }, [currentPage]);
  return (
    <div className="tech">
      <Banner />
      <div className="tech__posts">
        <div className="tech-official">
          <div className="tech-official-top">
            <p className="tech__title">Official</p>
            <button
              type="button"
              className={
                loginContext.id === -1
                  ? 'tech-write_button tech-write_button--hidden'
                  : 'tech-write_button'
              }
              onClick={onClick}
            >
              <img src={write} alt="write" className="tech-write__img" />
              <span>글쓰기</span>
            </button>
          </div>
          <Official />
        </div>
        <div className="tech-recent">
          <p className="tech__title">Recent posts</p>
          {currentPosts.map((item) => (
            <PostBox key={item.postId} post={item} />
          ))}
          <Pagination
            activePage={currentPage}
            itemsCountPerPage={7}
            totalItemsCount={currentPosts.length}
            pageRangeDisplayed={5}
            prevPageText="<"
            nextPageText=">"
            onChange={setCurrentPage}
          />
        </div>
      </div>
    </div>
  );
};

export default Tech;
