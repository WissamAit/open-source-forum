import { React, useState, useEffect } from "react";
import Container from "react-bootstrap/Container";
import NavbarWall from "../navbar/NavbarWall";
import { useLocation } from "react-router-dom";
import Moment from "react-moment";

const Wall = () => {
  const search = useLocation().search;
  const username = new URLSearchParams(search).get("username");
  const [posts, setPosts] = useState([]);
  const [refresh, setRefresh] = useState(false);
  const { REACT_APP_WORKING_ENV } = process.env;

  useEffect(() => {
    fetchForumPosts();
  }, [username, refresh]);

  const [postContent, setPostContent] = useState("");
  const handlePostContentChange = (event) => {
    event.preventDefault();
    setPostContent(event.target.value);
  };

  const [postTopic, setPostTopic] = useState("");
  const handlePostTopicChange = (event) => {
    event.preventDefault();
    setPostTopic(event.target.value);
  };

  const [postHashtags, setPostHashtags] = useState("");
  const handlePostHashtagsChange = (event) => {
    event.preventDefault();
    setPostHashtags(event.target.value);
  };

  const fetchForumPosts = () => {
    fetch(`${REACT_APP_WORKING_ENV}/api/forum/post/all`)
      .then((res) => res.json())
      .then((data) => {
        data.sort((a, b) => b.creationDate - a.creationDate).reverse();
        console.log(data);
        setPosts(data);
      })
      .catch(console.log);
  };

  const deletePost = (idPost) => {
    const requestOptions = {
      method: "DELETE",
      headers: { "Content-Type": "application/json", username: username },
    };
    fetch(`${REACT_APP_WORKING_ENV}/api/forum/post/${idPost}`, requestOptions)
      .then(console.log)
      .then((res) => setRefresh(!refresh))
      .catch(console.log);
  };

  const addPost = () => {
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json", username: username },
      body: JSON.stringify({
        username: username,
        topic: postTopic,
        message: postContent,
        hashtags: postHashtags,
      }),
    };
    fetch(`${REACT_APP_WORKING_ENV}/api/forum/post`, requestOptions)
      .then((response) => response.json())
      .then((post) => setRefresh(!refresh))
      .then(console.log)
      .catch(console.log);
  };

  const updateLike = (postId) => {
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json", username: username },
      body: JSON.stringify({
        username: username,
      }),
    };
    fetch(
      `${REACT_APP_WORKING_ENV}/api/forum/posts/${postId}/like`,
      requestOptions
    )
      .then((response) => response.json())
      .then((like) => setRefresh(!refresh))
      .catch(console.log);
  };

  const [isOpen, setIsOpen] = useState(false);

  const togglePopup = () => {
    setIsOpen(!isOpen);
  };

  return (
    <>
      <NavbarWall />
      <Container style={{ marginTop: "20px" }}>
        <div className="card gedf-card">
          <div className="card-header">
            <ul
              className="nav nav-tabs card-header-tabs"
              id="myTab"
              role="tablist"
            >
              <li className="nav-item">
                <a
                  className="nav-link active"
                  id="posts-tab"
                  data-toggle="tab"
                  href="#posts"
                  role="tab"
                  aria-controls="posts"
                  aria-selected="true"
                >
                  Make a publication
                </a>
              </li>
            </ul>
          </div>
          <div className="card-body">
            <div className="tab-content" id="myTabContent">
              <div
                className="tab-pane fade show active"
                id="posts"
                role="tabpanel"
                aria-labelledby="posts-tab"
              >
                <div className="form-group">
                  <label className="sr-only" for="message">
                    post
                  </label>
                  <input
                    className="form-control"
                    id="message"
                    rows="3"
                    placeholder="What is the topic of your post ?"
                    onChange={handlePostTopicChange}
                  />
                  <br />
                  <textarea
                    className="form-control"
                    id="message"
                    rows="3"
                    placeholder="Ok, share with us your knowledge !"
                    onChange={handlePostContentChange}
                  ></textarea>
                  <br />
                  <input
                    className="form-control"
                    id="message"
                    rows="3"
                    placeholder="What are your Hashtags ?"
                    onChange={handlePostHashtagsChange}
                  />
                </div>
              </div>
            </div>
            <div className="btn-toolbar justify-content-between">
              <div className="btn-group">
                <button
                  type="submit"
                  className="btn btn-primary"
                  onClick={addPost}
                >
                  share
                </button>
              </div>
            </div>
          </div>

          {posts.map((post, index) => {
            return (
              <>
                <div className="card gedf-card">
                  <div className="card-header">
                    <div className="d-flex justify-content-between align-items-center">
                      <div className="d-flex justify-content-between align-items-center">
                        <div className="mr-2">
                          <img
                            className="rounded-circle"
                            width="45"
                            src={`https://avatars.dicebear.com/api/human/${post.username}.svg?background=%230000ff`}
                            alt=""
                          />
                        </div>
                        <div className="ml-2">
                          <div className="text-muted h5 m-0">
                            {post.username}
                          </div>
                        </div>
                      </div>
                      <div>
                        <div className="dropdown">
                          <button
                            className="btn btn-link dropdown-toggle"
                            type="button"
                            id="gedf-drop1"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                          >
                            <i className="fa fa-ellipsis-h"></i>
                          </button>
                          <div
                            className="dropdown-menu dropdown-menu-right"
                            aria-labelledby="gedf-drop1"
                          >
                            <div className="h6 dropdown-header">
                              Configuration
                            </div>
                            <span
                              className="dropdown-item"
                              style={{ cursor: "pointer" }}
                              onClick={() => deletePost(post.id)}
                            >
                              <i
                                className="fa fa-trash"
                                style={{ color: "red" }}
                              ></i>{" "}
                              Delete
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="card-body">
                    <div className="text-muted h7 mb-2">
                      {" "}
                      <i className="fa fa-clock-o"></i>{" "}
                      <Moment format="YYYY/MM/DD HH:mm">
                        {post.creationDate}
                      </Moment>
                    </div>

                    <h5 className="card-title" style={{ color: "#007bff" }}>
                      {" "}
                      {post.topic}
                    </h5>

                    <p className="card-text">{post.message}</p>

                    <div>
                      {post.hashtags.split("#").map((hashtag, index) => {
                        return (
                          <span
                            style={{ marginRight: "0.2rem" }}
                            className="badge badge-primary"
                          >
                            {hashtag}
                          </span>
                        );
                      })}
                    </div>
                  </div>
                  <div className="card-footer">
                    <span
                      className="card-link cursor"
                      style={{ cursor: "pointer" }}
                      onClick={() => updateLike(post.id)}
                    >
                      <i className="fa fa-gittip"></i> Like ({post.likes.length}
                      )
                    </span>
                    <span
                      className="card-link cursor"
                      style={{ cursor: "pointer" }}
                      onClick={() => {}}
                    >
                      <i className="fa fa-comment"></i> Comment (
                      {post.comments.length})
                    </span>
                  </div>
                </div>
                <br />
              </>
            );
          })}
        </div>
      </Container>
    </>
  );
};

export default Wall;
